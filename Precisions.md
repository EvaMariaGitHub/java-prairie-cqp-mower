J'ai choisi de ne pas créer de classe Lawn car pour l'instant je n'en vois pas l'usage. 
La notion abstraite de cette classe est gérée par l'attribut max de type Point dans la classe Mower. 
Ce point représente les limites max de Lawn. 
Si l'application Mower évolue il me faudra peut etre créer cette classe, je verrai à ce moment là. 
C'est peut etre aussi une erreur de conception de ma part, j'essayerai de trouver une réponse.

Pour la classe Point j'ai choisis d'importer la classe java.awt.Point ce qui me dispense de coder une classe Point personnelle.

Le Mower "embarque" avec lui une séquence d'instruction. Cette séquence peut etre vide. 
Il peut se mouvoir de façon autonome grace à la séquence ou etre dirigé unitairement via ses méthodes (turn, forward).
