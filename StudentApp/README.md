## PostgreSQL commands to run:

```psql
CREATE DATABASE student_db;

\c student_db

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

```

```
mvn clean package
```

```
target/StudentApp.war
```

```
cp target/StudentApp.war /path/to/tomcat/webapps/
```

Start Tomcat if not running:

/path/to/tomcat/bin/startup.sh

Or restart it if running:

/path/to/tomcat/bin/shutdown.sh
/path/to/tomcat/bin/startup.sh

Tomcat will automatically explode the WAR file and deploy the app.
