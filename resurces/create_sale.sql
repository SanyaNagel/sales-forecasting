CREATE TABLE public.sale
(
    date timestamp with time zone NOT NULL,
    sale_id bigint,
    count bigint,
    price bigint,
    "promotion " bigint,
    PRIMARY KEY (sale_id)
)

TABLESPACE pg_default;

ALTER TABLE public.sale
    OWNER to postgres;

COMMENT ON TABLE public.sale
    IS 'Продажа - принадлежит определённому дню';