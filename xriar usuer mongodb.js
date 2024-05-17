
db.createUser({
    user: "myusermongodb",
    pwd: "Secret1234",
    roles: [
        { role: "readWrite", db: "test" }
    ]
})


db.createUser(
    {	user: "myusermongodb",
        pwd: "Secret1234",
    
        roles:[{role: "userAdminAnyDatabase" , db:"notification-db-webflux-local"}]})

mongodb://<credentials>@localhost:27017/?directConnection=true&serverSelectionTimeoutMS=2000&appName=mongosh+2.2.5
mongodb://myusermongodb@localhost:27017/

db.createRole({
    role: "readWriteAnyDatabase",
    privileges: [
      { resource: { anyResource: true }, actions: ["readWrite"] }
    ],
    roles: []
  })

  --------------------------------------------------

  db.createUser({
    user: "adminUser",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "notification-db-webflux-local" }
    ]
  })

  mongodb://adminUser:Secret1234@localhost:27017/
  