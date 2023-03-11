package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Team {

    private ArrayList<String> name;
    private ArrayList<Integer> cap;

    public Team(ArrayList Cap, ArrayList Name){
        this.cap = Cap;
        this.name = Name;
    }

    public Team() {
    }

    public ArrayList<Integer> getCap() {
        return cap;
    }

    public void setCap(ArrayList<Integer> cap) {
        this.cap = cap;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public void PlayerView(){
        System.out.println("CAP   NAME");
        for(int i=0; i<cap.size(); i++){
            System.out.print(cap.get(i) + "   ");
            System.out.println(name.get(i));
        }
        System.out.println("");
    }

    public static int OpponentTeamNo(int teamNo){
        int min = 1, max = 4;
        int x = (int) (Math.random() * (max - min + 1) + min);
        while (x==teamNo){
            x = (int) (Math.random() * (max - min + 1) + min);
        }
        return x;
    }

    public static Team slTeam(){
        ArrayList<String> slNames = new ArrayList<String>();
        slNames.add("Dasun Shanaka"); slNames.add("Avishka Fernando"); slNames.add("Wanidu Hasaranga"); slNames.add("Dushmantha  Chameera");
        slNames.add("Charith Asalanka"); slNames.add("Danushka Gunathilaka"); slNames.add("Chamika Karunaratne"); slNames.add("Lahiru Kumara");
        slNames.add("Maheesh Theekshana"); slNames.add("Bhanuka Rajapaksa"); slNames.add("Dhananjaya de Silva");

        ArrayList<Integer> slCaps = new ArrayList<Integer>();
        slCaps.add(58); slCaps.add(79); slCaps.add(80); slCaps.add(59); slCaps.add(87); slCaps.add(60); slCaps.add(88);
        slCaps.add(78); slCaps.add(90); slCaps.add(70); slCaps.add(83);

        return new Team(slCaps, slNames);
    }

    public static Team ausTeam(){
        ArrayList<String> ausNames = new ArrayList<String>();
        ausNames.add("Matthew Wade"); ausNames.add("Mitchell Starc"); ausNames.add("Glenn Maxwell"); ausNames.add("Nathan Coulter-Nile");
        ausNames.add("Billy Stanlake"); ausNames.add("Marcus Stoinis"); ausNames.add("D'Arcy Short"); ausNames.add("David Warner"); ausNames.add("Steve Smith");
        ausNames.add("Travis Head"); ausNames.add("Pat Cummins");

        ArrayList<Integer> ausCaps = new ArrayList<Integer>();
        ausCaps.add(53); ausCaps.add(59); ausCaps.add(58); ausCaps.add(61); ausCaps.add(85); ausCaps.add(74);
        ausCaps.add(90); ausCaps.add(32); ausCaps.add(43); ausCaps.add(75); ausCaps.add(51);

        return new Team(ausCaps, ausNames);
    }

    public static Team engTeam(){
        ArrayList<String> engNames = new ArrayList<String>();
        engNames.add("Dawid Malan"); engNames.add("Jake Ball"); engNames.add("Tom Curran"); engNames.add("Jason Roy");
        engNames.add("Jos Buttler"); engNames.add("Ben Stokes"); engNames.add("Chris Jordan"); engNames.add("Moeen Ali");
        engNames.add("Jonny Bairstow"); engNames.add("Adil Rashid"); engNames.add( "Sam Billings");

        ArrayList<Integer> engCaps = new ArrayList<Integer>();
        engCaps.add(81); engCaps.add(83); engCaps.add(79); engCaps.add(70); engCaps.add(54); engCaps.add(58);
        engCaps.add(65); engCaps.add(66); engCaps.add(56); engCaps.add(46); engCaps.add(71);

        return new Team(engCaps, engNames);
    }

    public static Team banTeam(){
        ArrayList<String> banNames = new ArrayList<String>();
        banNames.add("Mustafizur Rahman"); banNames.add("Soumya Sarkar"); banNames.add("Taskin Ahmed"); banNames.add("Liton Das");
        banNames.add("Mohammad Saifuddin"); banNames.add("Mohammad Naim"); banNames.add("Mahedi Hasan"); banNames.add("Afif Hossain");
        banNames.add("Mosaddek Hossain"); banNames.add("Rubel Hossain"); banNames.add("Mahmudullah");

        ArrayList<Integer> banCaps = new ArrayList<Integer>();
        banCaps.add(45); banCaps.add(44); banCaps.add(43); banCaps.add(46); banCaps.add(56); banCaps.add(67);
        banCaps.add(63); banCaps.add(58); banCaps.add(53); banCaps.add(23); banCaps.add(13);

        return new Team(banCaps, banNames);
    }

    public static Team indTeam(){
        ArrayList<String> indNames = new ArrayList<String>();
        indNames.add("Virat Kohli"); indNames.add("Bhuvneshwar"); indNames.add("Yuzvendra Chahal"); indNames.add("Rishabh Pant");
        indNames.add("Shikhar Dhawan"); indNames.add("Jasprit Bumrah"); indNames.add("Shardul Thakur");
        indNames.add("Ravichandran Ashwin"); indNames.add("Hardik Pandya"); indNames.add("Shreyas Iyer"); indNames.add("Shivam Dube");

        ArrayList<Integer> indCaps = new ArrayList<Integer>();
        indCaps.add(31); indCaps.add(45); indCaps.add(60); indCaps.add(68); indCaps.add(36); indCaps.add(57);
        indCaps.add(73); indCaps.add(30); indCaps.add(58); indCaps.add(70); indCaps.add(82);

        return new Team(indCaps, indNames);
    }

    public static Team nzTeam(){
        ArrayList<String> nzNames = new ArrayList<String>();
        nzNames.add("Rachin Ravindra"); nzNames.add("Hamish Bennett"); nzNames.add("Glenn Phillips"); nzNames.add("Martin Guptilll");
        nzNames.add("Tim Southee"); nzNames.add("Ish Sodhi"); nzNames.add("James Neesham"); nzNames.add("Colin de Grandhomme");
        nzNames.add("Devon Conway"); nzNames.add("Scott Kuggeleijin"); nzNames.add("Tom Bruce");

        ArrayList<Integer> nzCaps = new ArrayList<Integer>();
        nzCaps.add(90); nzCaps.add(83); nzCaps.add(74); nzCaps.add(37); nzCaps.add(30); nzCaps.add(64); nzCaps.add(59);
        nzCaps.add(51); nzCaps.add(84); nzCaps.add(80); nzCaps.add(70);

        return new Team(nzCaps, nzNames);
    }

    public static Team pakTeam(){
        ArrayList<String> pakNames = new ArrayList<String>();
        pakNames.add("Haider Ali"); pakNames.add("Shadab Khan"); pakNames.add("Babar Azam"); pakNames.add("Hasan Ali");
        pakNames.add("Mohammad Rizwan"); pakNames.add("Fakhar Zaman"); pakNames.add("Shaheen Afridi"); pakNames.add("Haris Rauf");
        pakNames.add("Iftikhar Ahmed"); pakNames.add("Imad Wasim"); pakNames.add("Sharjeel Khan");

        ArrayList<Integer> pakCaps = new ArrayList<Integer>();
        pakCaps.add(87); pakCaps.add(73); pakCaps.add(70); pakCaps.add(71); pakCaps.add(60); pakCaps.add(74);
        pakCaps.add(78); pakCaps.add(86); pakCaps.add(69); pakCaps.add(62); pakCaps.add(57);

        return new Team(pakCaps, pakNames);
    }

    public static Team wiTeam(){
        ArrayList<String> wiNames = new ArrayList<String>();
        wiNames.add("Oshane Thomas"); wiNames.add("Fabian Allen"); wiNames.add("Rovman Powell"); wiNames.add("Shimron Hetmyer");
        wiNames.add("Hayden Waish"); wiNames.add("Jason Holder"); wiNames.add("Obed McCoy"); wiNames.add("Chris Gayle");
        wiNames.add("Ravi Rampaul"); wiNames.add("Lendl Simmons"); wiNames.add("Kieron Pollard");

        ArrayList<Integer> wiCaps = new ArrayList<Integer>();
        wiCaps.add(77); wiCaps.add(75); wiCaps.add(66); wiCaps.add(69); wiCaps.add(82); wiCaps.add(61); wiCaps.add(79); wiCaps.add(65);
        wiCaps.add(13); wiCaps.add(18); wiCaps.add(26);

        return new Team(wiCaps, wiNames);
    }

    public static void TeamPlayers() throws IOException {
        FileWriter teamPlayers = new FileWriter("TeamPlayers.txt");

        try {
            teamPlayers.write("  Group A   \n");
            teamPlayers.write("Sri Lanka \n");
            for (int i=0; i<slTeam().getCap().size(); i++){
                teamPlayers.write(slTeam().getCap().get(i)+" - ");
                teamPlayers.write(slTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("Australia \n");
            for (int i=0; i<ausTeam().getCap().size(); i++){
                teamPlayers.write(ausTeam().getCap().get(i)+" - ");
                teamPlayers.write(ausTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("West Indies \n");
            for (int i=0; i<wiTeam().getCap().size(); i++){
                teamPlayers.write(wiTeam().getCap().get(i)+" - ");
                teamPlayers.write(wiTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("New Zealand \n");
            for (int i=0; i<nzTeam().getCap().size(); i++){
                teamPlayers.write(nzTeam().getCap().get(i)+" - ");
                teamPlayers.write(nzTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("  Group B   \n");
            teamPlayers.write("India \n");
            for (int i=0; i<indTeam().getCap().size(); i++){
                teamPlayers.write(indTeam().getCap().get(i)+" - ");
                teamPlayers.write(indTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("Bangladesh \n");
            for (int i=0; i<banTeam().getCap().size(); i++){
                teamPlayers.write(banTeam().getCap().get(i)+" - ");
                teamPlayers.write(banTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("England \n");
            for (int i=0; i<engTeam().getCap().size(); i++){
                teamPlayers.write(engTeam().getCap().get(i)+" - ");
                teamPlayers.write(engTeam().getName().get(i)+"\n");
            }
            teamPlayers.write(" \n");
            teamPlayers.write("Pakistan \n");
            for (int i=0; i<pakTeam().getCap().size(); i++){
                teamPlayers.write(pakTeam().getCap().get(i)+" - ");
                teamPlayers.write(pakTeam().getName().get(i)+"\n");
            }
            teamPlayers.close();
        }catch (IOException ignored) {}
    }
}
