#Se autenticar root
mongodb://fabiohpsouza:Hnkx@7701@localhost:27017

use admin

db.getUsers()



  db.createUser({
    user: "adminUser",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "notification-db-webflux-docker-local" }
    ]
  })

  db.createUser({
    user: "adminWebflux",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "notification-db-webflux-docker-local" }
    ]
  })

  db.createUser({
    user: "adminMongo",
    pwd: "Secret1234",
    roles: [
      { role: "dbOwner", db: "admin" }
    ]
  })

  mongodb://adminUser:Secret1234@localhost:27017/notification-db-webflux-docker-local?authSource=admin

  

  ---------------

  notification-db-webflux-docker-local> db.getUsers()
{
  users: [
    {
      _id: 'notification-db-webflux-docker-local.adminUser',
      userId: UUID('f7d043e5-2c0f-4c59-9146-a3e84e96885b'),
      user: 'adminUser',
      db: 'notification-db-webflux-docker-local',
      roles: [ { role: 'dbOwner', db: 'admin' } ],
      mechanisms: [ 'SCRAM-SHA-1', 'SCRAM-SHA-256' ]
    },
    {
      _id: 'notification-db-webflux-docker-local.adminWebflux',
      userId: UUID('e47ddfb6-1ef7-4249-b8a9-52bbab237b9d'),
      user: 'adminWebflux',
      db: 'notification-db-webflux-docker-local',
      roles: [
        { role: 'dbOwner', db: 'notification-db-webflux-docker-local' }
      ],
      mechanisms: [ 'SCRAM-SHA-1', 'SCRAM-SHA-256' ]
    }
  ],
  ok: 1
}