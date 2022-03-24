CREATE TABLE booking (
                      id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      period VARCHAR NOT NULL,
                      renter_id bigint NOT NULL,
                      tenant_id bigint NOT NULL,
                      price bigint not null
);

insert into booking (period, renter_id, tenant_id, price) values ('Iron man', 1,2, 40);


