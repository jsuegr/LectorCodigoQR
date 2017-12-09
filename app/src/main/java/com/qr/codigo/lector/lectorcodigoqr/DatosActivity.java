package com.qr.codigo.lector.lectorcodigoqr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class DatosActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mSlider;
    private TextView nombreObra;
    private TextView descripcion;
    private TextView fechaInicio;
    private TextView fechaConclusion;
    private TextView tipoLicitacion;
    private TextView noContrato;
    private TextView monto;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        getSupportActionBar().setTitle("Obras");

        String proyecto=null;
        proyecto = getIntent().getStringExtra("proyecto");
        Toast.makeText(this, proyecto, Toast.LENGTH_LONG).show();
        mSlider = (SliderLayout)findViewById(R.id.slider);
        nombreObra = (TextView) findViewById(R.id.txtNombreObra
        );
        descripcion = (TextView) findViewById(R.id.txtDescripcion);
        fechaInicio = (TextView) findViewById(R.id.txtFechaInicio);
        fechaConclusion = (TextView) findViewById(R.id.txtFConclusion);
        tipoLicitacion = (TextView) findViewById(R.id.txtTipolicitacion);
        noContrato = (TextView) findViewById(R.id.txtcontrato);
        monto = (TextView) findViewById(R.id.txtmonto);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        HashMap<String,Integer> images = new HashMap<String, Integer>();
        if(proyecto.equals("proyecto1")){
            images.put("imagen1",R.drawable.imagen1);
            images.put("imagen2",R.drawable.imagen2);
        }else if(proyecto.equals("proyecto2")){
            images.put("imagen3",R.drawable.imagen3);
            images.put("imagen4", R.drawable.imagen4);
        }else if(proyecto.equals("proyecto3")){
            images.put("imagen5", R.drawable.imagen5);
            images.put("imagen6", R.drawable.imagen6);
        }


        for(String name : images.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(images.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSlider.addSlider(textSliderView);
        }

        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(3000);
        mSlider.addOnPageChangeListener(this);

        if(proyecto.equals("proyecto2")){
            nombreObra.setText("Unidad Clemente Orozco");
            descripcion.setText("Obras de construcción en Cra. 54 No.64-245 Edif. Carnacol, Piso 9, Of. 9 A-B Barranquilla Colombia.");
            fechaInicio.setText("15 de agosto de 2015");
            fechaConclusion.setText("20 de diciembre de 2017");
            tipoLicitacion.setText("Estatal");
            noContrato.setText("4548123654");
            monto.setText("$ 8,000,000.00");
        }else if(proyecto.equals("proyecto3")){
            nombreObra.setText("Rehabilitación de la unidad deportiva Ciudad de Tucson");
            descripcion.setText(" Dimensionamiento de obras hidraúlicas (canales, vertedores,obras de toma, etc) en Nuevo León, Monterrey México. ");
            fechaInicio.setText("8 de abril de 2017");
            fechaConclusion.setText("15 de enero de 2019");
            tipoLicitacion.setText("Municipal");
            noContrato.setText("793167522");
            monto.setText("$ 10,584,000.00");
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rIntent = new Intent(DatosActivity.this, ReaderActivity.class);
                startActivity(rIntent);
            }
        });
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
