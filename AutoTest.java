import java.util.*;

class Auto
{
    public  String Kennzeichen = "J-AA 01";
    public  int Kilometerstand = 0;
    public  int Sitzplätze = 5;
    public  String Antenne = "eingefahren"; //0 = eingefahren 1 = ausgefahren
    

    public Auto()
    {
        
    }

    public Auto(String Kennzeichen)
    {
        this.Kennzeichen = Kennzeichen;
    }

    public String getKennzeichen()
    {
        System.out.println(Kennzeichen);
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
        Kilometerstand = Kilometerstand + Kilometer;
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
        System.out.println("Antenne zum Waschen eingefahren!");
        Antenne = "eingefahren";
    }

    public void wasche()
    {
        System.out.println("Auto wird gewaschen!");
    }

    public String toString()
    {
        return Kennzeichen + ":  " + Kilometerstand + "km  " + Sitzplätze + " Plätze  " + "Antenne " + Antenne;
    }
}

class PickUp extends Auto
{
    public int f;
    public int ladungPickUp;
    public PickUp(int Fassungsvermoegen)
    {
        this.f=Fassungsvermoegen;
        this.Sitzplätze=2;
    }

    public PickUp(String Kennzeichen, int Fassungsvermoegen)
    {
        this.f=Fassungsvermoegen;
        this.Kennzeichen = Kennzeichen;
        this.Sitzplätze = 2;
    }

    public int getLadung()
    {
        return ladungPickUp;
    }

    public boolean beladen(int ladung)
    {
        if(f>=ladung)
        {
            System.out.println("Pick-Up wurde erfolgreich beladen!");
            this.ladungPickUp = ladung;
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
        System.out.println("Antenne zum Waschen eingefahren!");
        System.out.println("PickUp zum Waschen entladen!");
        Antenne = "eingefahren";
        entladen();
    }

    public String toString()
    {
        return Kennzeichen + ":  " + Kilometerstand + "km  " + Sitzplätze + " Plätze  " + "Antenne " + Antenne +"  "+ ladungPickUp + "kg";
    }
}


public class AutoTest
{
    public static void main(String[] args)
    {
            Auto[] array  = new Auto[4];

            Auto auto1 = new Auto("SLF LS 372");
            auto1.fahre(30);

            PickUp pickup1 = new PickUp(50);
            pickup1.beladen(39);
            pickup1.entladen(3);
            pickup1.bereiteWaschenVor();

            PickUp pickup2 = new PickUp("SON SL 888", 5);
            pickup2.fahre(200);
            pickup2.beladen(10);
            pickup2.beladen(5);

            Auto auto2 = new Auto();
            auto2.fahre(399);
            auto2.bereiteWaschenVor();
            auto2.wasche();
            auto2.fahreAntenneAus();

            array[0]=auto1;
            array[1]=pickup1;
            array[2]=pickup2;
            array[3]=auto2;
            System.out.println(Arrays.toString(array));
        
    }
}