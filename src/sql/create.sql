create table actor(
    id serial primary key,
    "name" varchar(100) not null unique,
    age int check (age > 0)
)

create table movie(
    id serial primary key,
    "name" varchar(100) not null,
    year_of_production int check (year_of_production > 1900)
)

create table actor_movie(
    actor_id int references actor(id),
    movie_id int references movie(id),
    primary key (actor_id, movie_id)
)
