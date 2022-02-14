package domain;

import java.awt.*;
import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;

    public Point2D.Double getMiddelpunt() {
        return middelpunt;
    }

    public double getStraal() {
        return straal;
    }
    public Cirkel(Point2D.Double middelpunt, double straal)
    {
        setMiddelpunt(middelpunt);
        setStraal(straal);
    }

    private void setStraal(double straal) {
        if(straal <0 || straal >middelpunt.getX() ||straal>middelpunt.getY())
            throw new IllegalArgumentException();
        this.straal = straal;
    }

    public void setMiddelpunt(Point2D.Double middelpunt)
    {
        if(middelpunt == null)
            throw new IllegalArgumentException();
        this.middelpunt = middelpunt;
    }
    public double oppervlakte()
    {
        return this.straal*straal*Math.PI;
    }
    //formule (x-centerx)^2+(y-centery)^2<straal^2
    public boolean puntInCirkel(Point2D.Double punt)
    {
        if(punt == null)
            throw new IllegalArgumentException( );
        if(punt == middelpunt)
        {
            throw new IllegalArgumentException();
        }
        double dx= Math.pow((punt.getX()-middelpunt.getX()),2);
        double dy = Math.pow((punt.getY()-middelpunt.getY()),2);
        if(dx+dy<straal*straal)
            return true;
        else
            return false;
    }
    public void vergrotenStraal(double factor)
    {
        if(factor<0)
            throw new IllegalArgumentException();
        if(factor*straal<0)
            throw new IllegalArgumentException();
        if(factor*straal>middelpunt.getX()||factor*straal>middelpunt.getY())
            throw new IllegalArgumentException();
        straal *=factor;
    }
}
