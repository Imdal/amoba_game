create sequence hibernate_sequence start with 1 increment by 1

    create table Player (
       playerName varchar(255) not null,
        games bigint not null,
        wins bigint not null,
        winRow bigint not null,
        bestWinRow bigint not null,
        primary key (playerName)
    )
