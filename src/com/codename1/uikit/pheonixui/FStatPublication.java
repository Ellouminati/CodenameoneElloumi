package com.codename1.uikit.pheonixui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* package com.codename1.uikit.pheonixui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.sport.entities.Like;
import com.codename1.sport.services.ServiceLike;
import com.codename1.sport.utils.AbstractDemoChart;
import com.codename1.ui.Form;
import com.codename1.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class FStatPublication extends AbstractDemoChart {
    private List<Statis> listStatis = new ArrayList<Statis>();
    private int etap1 = 0;
    private int etap2 = 0;
    
    /**
     * Returns the chart name.
     *
     * @return the chart name
     */
   /* public String getName() {

        return "Statistique Publication";
    }
    
    public void remplir() {

        ServiceLike likedao = ServiceLike.getInstance();
        List<Like> ListCmd = likedao.getLikes();
        for (Like c : ListCmd) {

            
            Statis statis;
            if(c.getRate()==1){
                etap1++;
            }else
            {
                etap2++;
            }
            
            
    }
        listStatis.add(new Statis("Like", etap1));
            listStatis.add(new Statis("DisLike", etap2));
    }
    public int getRandomColor() {
        Random rnd = new Random();
        return ColorUtil.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (Statis s : listStatis) {

            series.add(StringUtil.replaceAll(s.getNom(),"Likes",""), s.getNombre());

        }
        return series;
    }

    /**
     * Returns the chart description.
     *
     * @return the chart description
     */
   /* public String getDesc() {
        return "Vue globale like et dislike";
    }

    /**
     * Executes the chart demo.
     *
     * @param context the context
     * @return the built intent
     */
   /* public Form execute() {
        remplir();
        double[] values = new double[30];
        int[] colors = new int[30];
        Integer i = 0;
        for (Statis s : listStatis) {
            values[i] = (double) s.getNombre();
            i++;
        }
        Integer j = 0;
        for (Statis s : listStatis) {
            colors[j] = getRandomColor();
            j++;
        }

        final DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextFont(largeFont);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        renderer.setBackgroundColor(ColorUtil.rgb(243, 242, 242));
        renderer.setApplyBackgroundColor(true);
        renderer.setLabelsColor(0000);
        renderer.setLabelsTextSize(10);
        final CategorySeries seriesSet = buildCategoryDataset("Project budget", values);
        final PieChart chart = new PieChart(seriesSet, renderer);
        ChartComponent comp = new ChartComponent(chart);
        comp.setZoomEnabled(true);
    comp.setPanEnabled(true);
        return wrap("Like/Dislike", comp);
        

    }

    public class Statis {

        private String nom;
        private int nombre;

        public Statis() {

        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getNombre() {
            return nombre;
        }

        public Statis(String nom, int nombre) {
            this.nom = nom;
            this.nombre = nombre;
        }

        public void setNombre(int nombre) {
            this.nombre = nombre;
        }

    }
    
}*/
