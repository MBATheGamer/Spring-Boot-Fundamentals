alter table wishlist drop foreign key wishlist_ibfk_2;
alter table wishlist
add constraint fk_wishlist_on_product foreign key (product_id) references products(id) on delete cascade;