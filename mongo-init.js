  db.createUser({
    user: "adminUser",
    pwd: "12345678",
    roles: [
      { role: "dbOwner", db: "admin" }
    ]
  });

  db.createUser({
    user: "mongouser",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "notification-db-webflux-docker-local" }
    ]
  });