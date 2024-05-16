SELECT 'CREATE DATABASE recooking'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'recooking')\gexec;





