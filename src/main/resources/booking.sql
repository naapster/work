CREATE TABLE booking (
                      id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      period VARCHAR NOT NULL,
                      rent_id bigint NOT NULL,
                      tenant_id bigint NOT NULL
);

insert into booking (period, rent_id, tenant_id) values ('Iron man', 1,2);


