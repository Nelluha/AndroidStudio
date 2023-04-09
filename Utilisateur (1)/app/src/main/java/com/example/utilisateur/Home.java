package com.example.utilisateur;



import android.annotation.SuppressLint;


import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;

public class Home extends Fragment {


    String Jsonurl;
    SearchView searchView;
    TextView textView;


    RecyclerView mainRecycler;
    List<Anime> animeList = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter(this.getContext(),animeList);
    List<Anime> filteredList = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);



        Jsonurl = "https://api.jikan.moe/v4/anime";
// Ajout manuelle  de quelques animes favoris
        animeList.add(new Anime( "Naruto Shippuden", "https://static.posters.cz/image/1300/affiches-et-posters/naruto-shippuden-group-ninja-war-i97861.jpg","L'histoire de Naruto Shippuden se déroule deux ans et demie après le départ de Naruto à Konoha. On y retrouve tous les personnages plus mûrs et plus âgés. L'intrigue tourne autour des aventures de Naruto et Sakura à la recherche de Sasuke, parti de Konoha pour acquérir de nouveaux pouvoirs, mais on y découvre aussi les objectifs de l'Akatsuki." ));
        animeList.add(new Anime("Dragon Ball Z", "https://m.media-amazon.com/images/M/MV5BNGM5MTEyZDItZWNhOS00NzNkLTgwZTAtNWIzY2IzZmExOWMxXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_FMjpg_UX1000_.jpg", "Dragon Ball Z reprend cinq ans après le mariage de Son Goku. Radditz, un mystérieux guerrier de l'espace, arrive sur Terre pour retrouver Goku, qui apprend alors qu'il vient d'une planète de guerriers dont il ne reste plus que quatre survivants. La trame de l'histoire repose sur une succession d'adversaires à combatstre, de plus en plus forts, mais il y a aussi fréquemment un contexte de quête ou de voyage qui donne un intérêt autre que les simples duels.\""));
        animeList.add(new Anime("One Piece", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/2239c7b46b2e491ae33b33ff980e9fb1.jpe", "Il fut un temps où Gold Roger était le plus grand de tous les pirates, le \"Roi des Pirates\" était son surnom. A sa mort, son trésor d'une valeur inestimable connu sous le nom de \"One Piece\" fut caché quelque part sur \"Grand Line\". De nombreux pirates sont partis à la recherche de ce trésor mais tous sont morts avant même de l'atteindre. Monkey D. Luffy rêve de retrouver ce trésor légendaire et de devenir le nouveau \"Roi des Pirates\". Après avoir mangé un fruit du démon, il possède un pouvoir lui permettant de réaliser son rêve. Il lui faut maintenant trouver un équipage pour partir à l'aventure !"));
        animeList.add(new Anime("Tokyo Ghoul", "https://static.posters.cz/image/750/affiches-et-posters/tokyo-ghoul-ken-kaneki-i28409.jpg", "Tokyo est devenue une ville cruelle et impitoyable, un endroit où des créatures vicieuses appelées «goules» existent aux côtés des humains. Les habitants de cette grande métropole vivent dans la peur constante de ces sauvages sanguinaires et de leur soif de chair humaine. Cependant, la plus grande menace que ces goules posent est leur capacité dangereuse à se faire passer pour des humains et de se fondre dans la société. L'histoire suit Ken Kaneki, un étudiant universitaire timide qui est immédiatement attiré par Rize Kamishiro, une lectrice avide comme lui. Cependant, Rize n'est pas exactement ce qu'elle pretend être. Durant un rendez-vous, elle manque de tuer Kaneki en lui dévoilant sa nature de goule. Il survit grâce aux organes de Rize, greffés à la place de ceux qu'elle avait détruit en l'attaquant. Le jeune homme est désormais un hybride, mi-humain, mi-goule et va vivre un véritable enfer."));
        animeList.add(new Anime("Jujutsu Kaisen", "https://www.picclickimg.com/nJsAAOSwcy1kI1Qz/Jujutsu-Kaisen-0-Blu-ray.webp", "Plus de 10 000 morts et disparus sont recensés chaque année au Japon. Les sentiments négatifs que relâchent les êtres humains sont en cause. Souffrance, regrets, humiliation : leur concentration dans un même endroit engendre des malédictions souvent mortelles... C'est ce que va découvrir Yuji Itadori, lycéen et membre du club d'occultisme. Il ne croit pas aux fantômes, mais il est doté d'une force physique hors norme qui représente un véritable atout pour les missions du groupe... jusqu'à ce que l'une d'elles prenne une mauvaise tournure. La relique qu'ils dénichent, le doigt découpé d'un démon millénaire, attire les monstres ! Sans réfléchir : le jeune homme avale la relique pour briser la malédiction ! Maintenant, il se trouve possédé par Ryômen Sukuna, le célèbre démon à deux visages. Cependant, contre toute attente, Yuji est toujours capable de garder le contrôle de son corps. Mais en dépit de cela, il est condamné à mort par l'organisation des exorcistes... Une décision qui ne pourra être repoussée qu'à une seule condition : trouver tous les doigts de Sukuna afin d'écarter la menace une bonne fois pour toutes !"));
        animeList.add(new Anime("Les memoires de vanitas", "https://www.nautiljon.com/images/anime/00/49/vanitas_no_carte_10194.webp","Paris, XIXè siècle. Au cours d'un voyage en dirigeable, Noé remarque une jeune fille qui semble plutôt mal en point. Il passe donc un peu de temps avec elle en lui racontant des histoires pour la rassurer, et en vient tout naturellement à lui expliquer les raisons de son voyage : il est à la recherche du \"Livre de Vanitas\" qui, selon la légende, a le pouvoir de tuer la majorité des vampires. Peu après, le duo est attaqué par de mystérieux individus prétendant que la demoiselle est très dangereuse et qu'elle doit venir avec eux." ));
        animeList.add(new Anime("Ousama ranking", "https://animotaku.fr/wp-content/uploads/2021/12/anime-ranking-of-kings-partie-2-trailer.jpeg", "Le royaume de Boss est en péril. Son fondateur, connu pour sa force herculéenne, est gravement malade, et l'héritier, le jeune prince Bojji, est loin d'avoir le profil pour prendre sa place... Sourd et muet, d'une faiblesse telle qu'il est incapable de manier l'épée, il est la cible de toutes les moqueries, du chevalier au paysan ! S'il accède au trône, le pays est promis à la déchéance dans le classement des rois, dont le principal critère est la puissance des souverains. De ce point de vue, c'est le prince cadet, Daida, qui remporte le soutien populaire... Pourtant, Bojji arbore un éternel sourire. Même quand une mystérieuse ombre lui ordonne de lui donner ses vêtements, il s'exécute avec plaisir ! Car, pour la première fois de sa vie, le garçon trouve un partenaire de conversation. Cet étrange voleur comprend ses paroles... Bojji lui dévoile alors son rêve : devenir le meilleur roi du monde !"));
        animeList.add(new Anime("Inuyasha", "https://fr.web.img4.acsta.net/pictures/20/10/07/12/28/5437750.jpg", "Une jeune fille de 15 ans, Kagome, est propulsée à l'époque Sengoku via le vieux puits du temple où elle habite avec sa famille. Elle rencontre Inuyasha, un demi-démon empalé sur un arbre. Ce dernier fut emprisonné d'un sort au moyen d'une flèche tirée en plein cœur par une miko nommée Kikyo. Kagome, la réincarnation de Kikyo, possède en elle la Shikon No Tama, une perle très convoitée qui permet d'accroître les pouvoirs du détenteur de celle-ci. Pour échapper à un démon attiré par la Shikon No Tama, elle délivre Inuyasha qui, une fois avoir tué le démon, exige à son tour la perle. A la suite de péripéties, la Shikon No Tama se brise en une multitude de morceaux. Inuyasha et Kagome se voient alors contraint de s'unir afin de récupérer les fragments dispersés dans le Japon médiéval, ne se doutant pas des nombreux périples qui les attendent..."));
        animeList.add(new Anime("Chainsaw man", "https://fr.web.img6.acsta.net/c_310_420/pictures/22/08/01/10/00/1492791.jpg","Pour rembourser ses dettes, Denji, jeune homme dans la dèche la plus totale, est exploité en tant que Devil Hunter avec son chien-démon-tronçonneuse, 'Pochita'. Mais suite à une cruelle trahison, il voit enfin une possibilité de se tirer des bas-fonds où il croupit ! Devenu surpuissant après sa fusion avec Pochita, Denji est recruté par une organisation et part à la chasse aux démons..." ));
        animeList.add(new Anime("Shingeki no kyojin", "https://adala-news.fr/wp-content/uploads/2020/12/Shingeki-no-Kyojin-FInal-Season-image-scaled.jpg", "Il y a 107 ans, les Titans ont presque exterminé la race humaine. Ces Titans mesurent principalement une dizaine de mètres et ils se nourrissent d'humains. Les humains ayant survécus à cette extermination ont construit une cité fortifiée avec des murs d'enceinte de 50 mètres de haut pour pouvoir se protéger des Titans. Pendant 100 ans les humains ont connu la paix. Eren est un jeune garçon qui rêve de sortir de la ville pour explorer le monde extérieur. Il mène une vie paisible avec ses parents et sa sœur Mikasa dans le district de Shiganshina. Mais un jour de l'année 845, un Titan de plus de 60 mètres de haut apparaît. Il démolit une partie du mur du district de Shiganshina et provoque une invasion de Titans. Eren verra sa mère se faire dévorer sous ses yeux sans rien pouvoir faire. Il décidera après ces événements traumatisants de s'engager dans les forces militaires de la ville avec pour but d'exterminer tous les Titans qui existent."));
        animeList.add(new Anime("My Hero Academia", "https://m.media-amazon.com/images/M/MV5BOGZmYjdjN2UtNjAwZi00YmEyLWFhNTEtNjM1OTc5ODg0MGEyXkEyXkFqcGdeQXVyMTA1NjQyNjkw._V1_FMjpg_UX1000_.jpg", "Dans un futur proche suite à une mutation génétique, 80% de la population mondiale possède des super-pouvoirs appelés \"Alters\". Les super-héros protègent la population mondiale face aux super-vilains qui utilisent leur Alter à des fins maléfiques. Le plus célèbre des super-héro se nomme All Might. Izuku Midoriya en est fan, et rêve d'intégrer la filière super-héroïque du lycée Yuei pour suivre les traces de son idole ainsi devenir le plus grand des super-héros. Malheureusement, Izuku ne possède pas de pouvoir."));
        animeList.add(new Anime("Demon Slayer", "https://fr.web.img6.acsta.net/pictures/19/09/18/13/46/0198270.jpg","Depuis les temps anciens, il existe des rumeurs concernant des démons mangeurs d'hommes qui se cachent dans les bois. Pour cette raison, les citadins locaux ne s'y aventurent jamais la nuit. La légende raconte aussi qu'un tueur de démons déambule la nuit, chassant ces démons assoiffés de sang. Pour le jeune Tanjirô, ces rumeurs vont bientôt devenir sa dure réalité ... Depuis la mort de son père, Tanjirô a pris sur lui pour subvenir aux besoins de sa famille. Malgré cette tragédie, ils réussissent à trouver un peu de bonheur au quotidien. Cependant, ce peu de bonheur se retrouve détruit le jour où Tanjirô découvre que sa famille s'est fait massacrer et que la seule survivante, sa sœur Nezuko, est devenue un démon. À sa grande surprise, Nezuko montre encore des signes d'émotion et de pensées humaines. Ainsi, commence la dure tâche de Tanjirô, celle de combatstre les démons et de faire redevenir sa sœur humaine." ));
        animeList.add(new Anime("Boruto", "https://fr.web.img4.acsta.net/pictures/19/08/07/16/35/5393471.jpg","content=\"Depuis que son père occupe la plus haute fonction du village de Konoha, Boruto Uzumaki, le fils de Nanadaime Hokage et Hinata Hyuga, vit dans l'ombre de son père. Cherchant toujours à attirer l'attention de ce dernier, Boruto a pris la ferme résolution de surpasser son paternel. Mais la vie que mènent les ninjas de haute-volée est rythmée par les missions complexes et les entraînements rigoureux, notre jeune héros va d'ailleurs, apprendre à ses dépens que devenir le meilleur ninja, n'est point une tâche aisée. En compagnie de Sarada, l'enfant de Sasuke Uchiha et Sakura Haruno, Boruto va dès lors découvrir le monde des shinobis, ainsi que ses fondements...\"" ));
        animeList.add(new Anime("Haikyuu", "https://fr.web.img5.acsta.net/pictures/19/09/27/13/12/0190127.jpg", "Shôyô Hinata, surnommé Shô, aime plus que tout jouer au volley-ball et ce, malgré sa petite taille. Malheureusement, suite à une sévère défaite, son club de collège a été dissous, tous les membres étant partis. Mais Shô est bien décidé à jouer de nouveau et choisit son futur lycée en fonction de son ambition. Il intègre donc le lycée Karasuno, où a joué son idole, le Petit Géant, tout en espérant faire aussi bien que lui."));
        animeList.add(new Anime("Bleach", "https://adala-news.fr/wp-content/uploads/2022/08/BLEACH-Thousand-Year-Blood-War.jpg", "Kurosaki Ichigo, un étudiant de quinze ans aux cheveux orange qui aime la bagarre (comme son père) a la particularité de voir les fantômes ainsi que de pouvoir les toucher. Cela l'amène à rencontrer Kuchiki Rukia, un Shinigami (dieu de la mort) qui combats un Hollow. Le déroulement du combats amène Kuchiki à donner ses pouvoirs à Ichigo qui deviens alors lui même un Shinigami. C'est maintenant à son tour de protéger la ville des Hollows."));
        animeList.add(new Anime("Fullmetal alchemist brotherhood", "https://fr.web.img6.acsta.net/pictures/19/07/29/15/50/2364027.jpg","Cette version est une seconde adaptation du manga de Hiromu Arakawa. Elle est bien plus fidèle au manga que la précédente version, et le design change quelque peu. Edward Elric et son frère Alphonse Elric sont de jeunes Alchimistes. En tentant de ramener leur mère à la vie, ils ont payé un lourd tribut, et ils tentent désormais de récupérer ce qu'ils ont perdu. Pour cela, Edward est devenu Alchimiste d'État : le Fullmetal Alchemist. Mais au cours de leurs recherches, bien des épreuves attendent les deux frères et des êtres étranges : les Homonculus, les poursuivent." ));
        animeList.add(new Anime("Black Clover", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/e108ae17d8d0407417cac40eb52d849a.jpe", "Asta et Yuno sont deux adolescents de 15 ans qui ont grandi ensemble dans un petit village du royaume de Clover. Leur but ultime à tous les deux est de devenir le prochain empereur-mage ! Étrangement, dans ce royaume, Asta est le seul qui soit incapable de produire la moindre étincelle magique. Loin d'être découragé, il participe tout de même avec son ami (et rival) Yuno à la cérémonie annuelle de remise des grimoires qui rassemble les jeunes de 15 ans dans tout le royaume de Clover. Lors de cette cérémonie, Yuno recevra un grimoire légendaire. Ce qui n'est pas le cas d'Asta car malheureusement pour lui, aucun grimoire ne lui sera attribué ce jour là. Mais Asta ne se laissera pas abattre, peut importe les efforts qu'il aura à fournir, il compte bien rivaliser avec Yuno pour aller au bout de son rêve...."));
        animeList.add(new Anime("Hunter x hunter", "https://fr.web.img5.acsta.net/pictures/19/08/01/09/52/4803203.jpg","Le jeune Gon vit sur une petite île avec sa tante. Abandonné par son père qui est un Hunter, à la fois un aventurier et un chasseur de primes, Gon décide à l'âge de 12 ans de partir pour devenir un Hunter. Cela ne sera pas chose aisée, il devra passer une suite de tests et examens en compagnie de milliers d'autres prétendants au titre de Hunter. Il sera aidé par de nouvelles connaissances qui aspirent au même but que lui, telles que Kurapika, Leorio et Killua." ));
        animeList.add(new Anime("Fairy tail", "https://www.nautiljon.com/images/anime/00/34/fairy_tail_1343.webp","Lucy est une jeune magicienne qui désire par dessus tout entrer dans une guilde magique. Elle décide de se rendre à Harujion afin d'obtenir des infos sur les guildes, particulièrement la guilde Fairy Tail. Lors de ses recherches, elle rencontre le mystérieux Salamander, membre de la célèbre guilde Fairy Tail. Malheureusement ce dernier n'est qu'un charlatan qui utilise des enchantements pour envoûter des femmes et ainsi les revendre au marché d'esclaves ! Alors que Lucy se trouve sous l'envoûtement de Salamander, un garçon mystérieux du nom de Natsu accompagné d'un chat bleu pouvant parler appelé Happy, la percute et rompt le sortilège de Salamander. Pour remercier Natsu et Happy, elle décide de les inviter au restaurant. Plus tard, Salamander lui fait une proposition : si elle vient à la fête sur le bateau, qu'il organise, il la fera entrer chez Fairy Tail. Lucy accepte et s'y rend. A la fête, elle se rend compte que Salamander n'est qu'un escroc et qu'il ne fait même pas partie de Fairy Tail. Elle veut fuir mais, alors qu'elle est sur le point de se faire kidnapper, Natsu et Happy arrivent et la sauvent. C'est alors qu'elle découvre qu'ils sont des mages et qu'ils font partie de Fairy Tail. C'est le début des aventures de Natsu et Lucy au sein du monde magique de Fairy Tail !" ));
        animeList.add(new Anime("Death note", "https://fr.web.img5.acsta.net/pictures/18/01/18/14/35/2024405.jpg","Light Yagami, un jeune étudiant surdoué, ramasse un jour le \"Death Note\", un carnet tenu auparavant par un shinigami (Dieu de la mort), Ryuk, qui apparemment s'ennuyait dans son monde. Il suffit d'écrire le nom d'une personne dans ce carnet, et celle-ci meurt (selon certaines conditions que le shinigami expliquera à Light lors de leur rencontre). C'est ainsi qu'avec le \"Death Note\" entre les mains, Light décide de débarrasser la planète de tous les criminels pour en faire un monde juste, un monde parfait. Cependant, qui est-il pour juger les gens ? Il devient donc le pire criminel recherché de toute la planète..." ));



        mainRecycler = view.findViewById(R.id.main_recycler);
//Lance la requete JSON
        GetData getData = new GetData();
        getData.execute();



//Barre de recherche filtant les animes par rapport a leurs noms
        /*searchView = view.findViewById(R.id.searchbar);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });*/
        return view;
    }

   /* private void filterList(String newText) {
        for (Anime anime : animeList) {
            if (anime.getTitle().toLowerCase().contains(newText.toLowerCase())) {
                // Toast.makeText(this.getContext(), "ICI", Toast.LENGTH_SHORT).show();
                filteredList.add(anime);
                Toast.makeText(this.getContext(), anime.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this.getContext(), "Aucun résultat pour cette recherche", Toast.LENGTH_SHORT).show();
        } else {
            setMainRecycler(filteredList);


        }
    }*/

//Recupertation des noms, url d'images et synopsis et création d'une liste animes
    private class GetData extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {

            String current="";

            try{
                URL url;
                HttpURLConnection urlConnection = null;
                try{
                    url = new URL(Jsonurl);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonObject1 = jsonObject.getJSONArray("data");
                for (int i=0;i<jsonObject1.length();i++){
                    JSONObject jsonObject2 = jsonObject1.getJSONObject(i);
                    Anime anime = new Anime();

                    String titre = jsonObject2.getString("title");
                    JSONObject jsonObject3 = jsonObject2.getJSONObject("images");
                    JSONObject jsonObject4 = jsonObject3.getJSONObject("jpg");
                    anime.setImage(jsonObject4.getString("image_url"));
                    String img = jsonObject4.getString("image_url");
                    anime.setSynopsis(jsonObject2.getString("synopsis"));
                    anime.setImage(img);
                    anime.setTitle(titre);
                    animeList.add(anime);

                }

                setMainRecycler(animeList);

                } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }

        }
        }


    public void setMainRecycler(List<Anime> animeList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter(getContext(), animeList);
        mainRecycler.setAdapter(mainAdapter);

    }

        }
