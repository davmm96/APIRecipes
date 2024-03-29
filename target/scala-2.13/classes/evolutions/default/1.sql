# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ingredient (
  id                            bigint generated by default as identity not null,
  name                          varchar(255),
  constraint pk_ingredient primary key (id)
);

create table recipe (
  id                            bigint generated by default as identity not null,
  name                          varchar(255),
  minutes                       integer,
  serves                        integer,
  parent_user_id                bigint,
  steps_id                      bigint,
  type_id                       bigint,
  constraint uq_recipe_steps_id unique (steps_id),
  constraint pk_recipe primary key (id)
);

create table recipe_ingredient (
  recipe_id                     bigint not null,
  ingredient_id                 bigint not null,
  constraint pk_recipe_ingredient primary key (recipe_id,ingredient_id)
);

create table recipe_type (
  id                            bigint generated by default as identity not null,
  type_name                     varchar(255),
  constraint pk_recipe_type primary key (id)
);

create table steps (
  id                            bigint generated by default as identity not null,
  steps                         varchar(255),
  constraint pk_steps primary key (id)
);

create table user (
  id                            bigint generated by default as identity not null,
  nick                          varchar(255),
  pass                          varchar(255),
  constraint pk_user primary key (id)
);

create index ix_recipe_parent_user_id on recipe (parent_user_id);
alter table recipe add constraint fk_recipe_parent_user_id foreign key (parent_user_id) references user (id) on delete restrict on update restrict;

alter table recipe add constraint fk_recipe_steps_id foreign key (steps_id) references steps (id) on delete restrict on update restrict;

create index ix_recipe_type_id on recipe (type_id);
alter table recipe add constraint fk_recipe_type_id foreign key (type_id) references recipe_type (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_recipe on recipe_ingredient (recipe_id);
alter table recipe_ingredient add constraint fk_recipe_ingredient_recipe foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_ingredient on recipe_ingredient (ingredient_id);
alter table recipe_ingredient add constraint fk_recipe_ingredient_ingredient foreign key (ingredient_id) references ingredient (id) on delete restrict on update restrict;


# --- !Downs

alter table recipe drop constraint if exists fk_recipe_parent_user_id;
drop index if exists ix_recipe_parent_user_id;

alter table recipe drop constraint if exists fk_recipe_steps_id;

alter table recipe drop constraint if exists fk_recipe_type_id;
drop index if exists ix_recipe_type_id;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_recipe;
drop index if exists ix_recipe_ingredient_recipe;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_ingredient;
drop index if exists ix_recipe_ingredient_ingredient;

drop table if exists ingredient;

drop table if exists recipe;

drop table if exists recipe_ingredient;

drop table if exists recipe_type;

drop table if exists steps;

drop table if exists user;

