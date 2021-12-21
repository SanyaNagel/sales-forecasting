CREATE TABLE public."product "
(
    product_id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name character varying(500) NOT NULL,
    category character varying(300),
    expiration_date date,
    PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

ALTER TABLE public."product "
    OWNER to postgres;

COMMENT ON TABLE public."product "
    IS 'Продукт';


ALTER TABLE public.sale
    ADD FOREIGN KEY (product_id)
    REFERENCES public."product " (product_id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;