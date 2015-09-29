CREATE TABLE keystore_profile(
   id BIGINT PRIMARY KEY  NOT NULL,
   keystore_type  TEXT    NOT NULL,
   creation_time  DATE     NOT NULL,
   passphrase     TEXT NOT NULL
);