import java.util.*;

class Auto
{
    protected  String Kennzeichen;
    protected  int Kilometerstand;
    protected  int Sitzplätze;
    protected  String Antenne; 
    

    //Konstruktor für Auto mit Standartkennzeichen
    public Auto()
    {
        this.Kennzeichen = "J-AA 01";
        this.Kilometerstand = 0;
        this.Sitzplätze = 5;
        this.Antenne = "eingefahren";
    }

    //Konstruktor für Auto mit besonderem Kennzeichen
    public Auto(String Kennzeichen)
    {
        this.Kennzeichen = Kennzeichen;
        this.Kilometerstand=0;
        this.Sitzplätze = 5;
        this.Antenne = "eingefahren";
    }

    public String getKennzeichen()
    {
        return Kennzeichen;
    }

    public int getKilometerstand()
    {
        return Kilometerstand;
    }

    public int getSitzplaetze()
    {
        return Sitzplätze;
    }

    public void fahre(int Kilometer)
    {
        System.out.println(Kilometer +" km gefahren!");
        this.Kilometerstand = Kilometerstand + Kilometer;
    }

    public void fahreAntenneAus()
    {
        System.out.println("Antenne ausgefahren!");
        Antenne = "ausgefahren";
    }

    public void fahreAntenneEin()
    {
        System.out.println("Antenne eingefahren!");
        Antenne = "eingefahren";
    }

    public void bereiteWaschenVor()
    {
        System.out.println("Waschen wird vorbereitet...");
        fahreAntenneEin();
    }

    public void wasche()
    {
        bereiteWaschenVor();
        System.out.println("Auto wird gewaschen!");
    }

    public String toString()
    {
        return Kennzeichen + ":  " + Kilometerstand + "km  " + Sitzplätze + " Plätze  " + "Antenne " + Antenne;
    }
}

class PickUp extends Auto
{
    private int f;
    private int ladungPickUp;
    public PickUp(int Fassungsvermoegen)
    {
        super();
        this.f=Fassungsvermoegen;
        this.ladungPickUp = 0;
        this.Sitzplätze = 2;
    }

    public PickUp(String Kennzeichen, int Fassungsvermoegen)
    {
        super(Kennzeichen);
        this.f=Fassungsvermoegen;
        this.ladungPickUp = 0;
        this.Sitzplätze = 2;
    }

    public int getLadung()
    {
        return ladungPickUp;
    }

    public boolean beladen(int ladung)
    {
        if(f >= ladungPickUp + ladung)
        {
            System.out.println("Pick-Up wurde erfolgreich mit " + ladung +"kg beladen!");
            this.ladungPickUp = ladung + ladungPickUp;
            return true;
        }
        else
        {
            System.out.println("Fassungsvermögen reicht nicht aus!");
            return false;
        }
    }

    public void entladen(int ladung)
    {
        System.out.println("Ladung wurde um " + ladung + "kg verringert");
        if(ladungPickUp-ladung<0)
        {
            ladungPickUp = 0;
        }
        else
        {
            ladungPickUp = ladungPickUp-ladung;
        }
    }

    public void entladen()
    {
        entladen(getLadung());
    }

    public void bereiteWaschenVor()
    {
        System.out.println("Waschen wird vorbereitet...");
        fahreAntenneEin();
        entladen();
    }

    public String toString()
    {
        return Kennzeichen + ":  " + Kilometerstand + "km  " + Sitzplätze + " Plätze  " + "Antenne " + Antenne +"  "+ f + "kg Fassungsvermoegen  " +  ladungPickUp + "kg Ladung";
    }
}


public class AutoTest
{
    public static void main(String[] args)
    {
            Auto[] array = new Auto[4];

            Auto auto1 = new Auto("SLF LS 372");
            PickUp pickup1 = new PickUp(50);
            PickUp pickup2 = new PickUp("SON SL 888", 5);
            Auto auto3 = new Auto();

            array[0]=auto1;
            array[1]=pickup1;
            array[2]=pickup2;
            array[3]=auto3;

            


            System.out.println(Arrays.toString(array));


            auto1.fahre(30);

            pickup1.beladen(39);
            pickup1.entladen(3);
            pickup1.bereiteWaschenVor();
            
            pickup2.fahre(200);
            pickup2.beladen(10);
            pickup2.beladen(5);
            
            auto3.fahre(30);
            auto3.wasche();
            auto3.fahreAntenneAus();
            
            System.out.println(Arrays.toString(array));
        
    }
}