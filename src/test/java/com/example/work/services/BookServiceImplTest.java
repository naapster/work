package com.example.work.services;

import com.example.work.exceptions.BookingExistanceException;
import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;
import com.example.work.models.Renter;
import com.example.work.repository.BookingRepository;
import com.example.work.repository.ObjectRentRepository;
import com.example.work.repository.RenterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class BookServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public BookingService bookingService() {
            return new BookServiceImpl();
        }
    }

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @MockBean
    private RenterRepository renterRepository;

    @MockBean
    private ObjectRentRepository objectRentRepository;

    @BeforeEach
    public void setUp() {
        Renter owner2= new Renter(2L, "Mateusz");
        Renter renter2 = new Renter(4L, "Robert");

        ObjectRent objectRent2 = new ObjectRent(2L, "house2", 1500, 150);
        Booking booking1 = new Booking(2L, owner2, renter2, objectRent2, 3000, Date.valueOf(LocalDate.of(2022, 1, 15)), Date.valueOf(LocalDate.of(2022, 3, 18)));
        Booking booking2 = new Booking(3L, owner2, renter2, objectRent2, 3000, Date.valueOf(LocalDate.of(2022, 1, 15)), Date.valueOf(LocalDate.of(2022, 3, 15)));

        Mockito.when(bookingRepository.getBookingByObjectRentId(2L))
                .thenReturn(List.of(booking1, booking2));
    }

    @Test
    void getBookingByObjectRentId()
    {
        List<Booking> allBookingByObjectRentId = bookingService.getAllBookingByObjectRentId(2L);
        Booking booking = allBookingByObjectRentId.get(0);
        assertEquals("Mateusz", booking.getOwner().getName());
    }

    @Test
    void getBookingByObjectRentIdThrowsExceptions()
    {
        Exception exception = assertThrows(BookingExistanceException.class, () -> {
            bookingService.getAllBookingByObjectRentId(4L);
        });

        String message = exception.getMessage();

        assertTrue(message.contains("Booking for object rent id 4 not exist"));
    }
}