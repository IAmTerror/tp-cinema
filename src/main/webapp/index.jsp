<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Listes</h2>
<p><a href="liste?sort=name_asc">Liste des films classés par ordre alphabétique ascendant</a></p>
<p><a href="liste?sort=name_desc">Liste des films classés par ordre alphabétique descendant</a></p>
<p><a href="liste?sort=note_asc">Liste des films classés par note, classement ascendant</a></p>
<p><a href="liste?sort=note_desc">Liste des films classés par note, classement descendant</a></p>

<h2>Rechercher un film</h2>
<form action="/recherche" method="post">
    <div>
        <label for="titre">Taper un titre de film :</label>
        <input type="text" id="titre" name="titre" />
    </div>
    <br />
    <div class="button">
        <button type="submit">Effectuer une recherche</button>
    </div>
</form>

<p><a href="historique">Historique de la session utilisateur</a></p>
</body>
</html>
