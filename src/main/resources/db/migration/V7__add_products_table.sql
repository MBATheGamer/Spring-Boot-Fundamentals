create table products(
  id bigint auto_increment primary key,
  name varchar(255) not null,
  price decimal(10, 2),
  category_id tinyint,
  foreign key (category_id) references categories(id) on delete restrict
);