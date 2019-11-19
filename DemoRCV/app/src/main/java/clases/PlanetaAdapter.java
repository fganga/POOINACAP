package clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demorcv.R;

import java.util.ArrayList;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaHolder>  {
    Context context;
    ArrayList<Planeta> planetas;


    public PlanetaAdapter(Context context, ArrayList<Planeta> planetas) {
        this.context = context;
        this.planetas = planetas;
    }

    @NonNull
    @Override
    public PlanetaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);

        return new PlanetaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaHolder holder, final int position) {
        Planeta planeta = planetas.get(position);
        holder.definirDetalles(planeta);


    }

    @Override
    public int getItemCount() {
        return planetas.size();
    }


}
class PlanetaHolder extends RecyclerView.ViewHolder   {
    public View view;
    private TextView txvNombrePlaneta, txvDistanciaSol, txvGravedad, txvDiametro;

    private ItemClickListener itemClickListener;

    public PlanetaHolder(@NonNull View itemView) {
        super(itemView);
        txvNombrePlaneta    = itemView.findViewById(R.id.txv_nombre);
        txvDistanciaSol     = itemView.findViewById(R.id.txv_distancia_sol);
        txvGravedad         = itemView.findViewById(R.id.txv_gravedad);
        txvDiametro         = itemView.findViewById(R.id.txv_diametro);


    }
    public void definirDetalles(Planeta planeta){
        txvNombrePlaneta.setText("Nombre " + planeta.getNombrePlaneta());
        txvDistanciaSol.setText("Distancia sol :" + planeta.getDistanciaSol() + "kms");
        txvGravedad.setText("Gravedad :" + planeta.getGravedad() + "N/kg");
        txvDiametro.setText("Diametro :" + planeta.getDiametro() + "kms.");
    }



}
