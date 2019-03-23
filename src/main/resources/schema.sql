
create table movie
(
  name varchar(255) not null,
  genre varchar(255) not null,
  year_released varchar(4) not null,
  rating varchar(10) not null,
  last_updated_date TIMESTAMP not null,
  created_date TIMESTAMP not null,
  primary key(name)
);