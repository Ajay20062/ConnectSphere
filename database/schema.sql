CREATE DATABASE IF NOT EXISTS connectsphere;
USE connectsphere;
-- Hibernate creates/updates tables on first run (ddl-auto=update).
-- Core tables: users, posts, follows, stories, communities, messages.
-- Foreign keys are generated from JPA @ManyToOne mappings.
