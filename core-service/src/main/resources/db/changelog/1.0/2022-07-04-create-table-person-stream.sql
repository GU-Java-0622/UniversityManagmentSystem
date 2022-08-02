create table person_stream
(
    person_id bigint not null
        constraint fkoghvaybox8he15hxu8og9d9yn
            references persons,
    stream_id bigint not null
        constraint fktrkcxg25ix2aeo47a4r2e9kt9
            references active_stream
);



