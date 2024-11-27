# cacib-messaging-interview

Partner Management Application
Cette application permet d'envoyer des messages vers une Queue IBM. La lecture d'un message permet de le sauvegarder dans une base relationnelle PostgreSQL. Elle permet aussi d'afficher les messages reçus dans la Queue et les partenaires de la banques. 

Cette application est composée de: 
 - Un frontend en Angular 17, Node 20
 - Un backend en Java 17 basé sur le Framework Spring Boot
 - Un serveurr IBM MQ
 - Une serveur de base de données PostgreSQL


![image](https://github.com/user-attachments/assets/94a068e4-38f3-4014-abf7-40a43bab188e)



### **Installation**

#### **Cloner le repôt**
```bash
git clone https://github.com/ameniJmaiel/cacib-messaging-interview.git
cd partner-management-app
```
---

### **Lancement avec docker-compose**

   ```bash
   cd manifests && docker-compose up -d
   ```

   Accès à l'application :
   ```
   http://localhost:4200
   ```

   Accès au Swagger :
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## **API Endpoints**

### **Queue*
| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| `GET`  | `/mq/read`      | Lit un message depuis une queue       |
| `GET`  | `/mq/send`      | Envoie un message dans une queue       |

### **Messages**
| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| `GET`  | `/messages/all`      | affiche tous les messages       |

### **Partnaires**
| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| `GET`  | `/partners/all`      | affiche tous les partnaires       |
| `POST` | `/partners/create`      | ajoute un partenaire        |
| `DELETE` | `/partners/{id}` | supprime un partenaire |

---
