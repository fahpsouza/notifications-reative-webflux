#Se autenticar root
mongodb://fabiohpsouza:Hnkx@7701@localhost:27017

use admin

db.getUsers()



db.createRole({
    role: "readWriteAnyDatabase",
    privileges: [
      { resource: { anyResource: true }, actions: ["readWrite"] }
    ],
    roles: []
  })


  db.createUser({
    user: "adminUser",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "admin" }
    ]
  })

  db.createUser({
    user: "adminWebflux",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "notification-db-webflux-docker-local" }
    ]
  })

  mongodb://adminUser:Secret1234@localhost:27017/notification-db-webflux-docker-local?authSource=admin