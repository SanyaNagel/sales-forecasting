CREATE TABLE public.batch_goods
(
    batch_goods_id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    date_delivery date NOT NULL,
    product_id integer NOT NULL,
    PRIMARY KEY (batch_goods_id),
    FOREIGN KEY (product_id)
        REFERENCES public."product " (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.batch_goods
    OWNER to postgres;