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
        System.out.println(Kilometer +" gefahren!");
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
        return Kennzeichen + ": " + Kilometerstand + " Kilometer gefahren, " + Sitzplätze + " Sitzplätze, " + "Antenne " + Antenne;
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
        System.out.println("Ladung wurde um " + ladung + " verringert");
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
        return Kennzeichen + ": " + Kilometerstand + " Kilometer gefahren, " + Sitzplätze + " Sitzplätze, " + "Antenne " + Antenne + ", " + f +" Liter Fassungsvermögen" + ", " + ladungPickUp + " Liter Ladung";
    }
}


public class AutoTest
{
    public static void main(String[] args)
    {
            //die Ausgabe muss ich noch schöner machen, sonst stimmt aber alles
            Auto[] array  = new Auto[3];
            Auto auto1 = new Auto("SLF LS 372");
            array[0]=auto1;
            PickUp pickup1 = new PickUp(50);
            pickup1.beladen(39);
            pickup1.entladen(3);
            pickup1.bereiteWaschenVor();
            array[1]=pickup1;
            System.out.println(Arrays.toString(array));
        
    }
}