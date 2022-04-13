package uz.quar.kompyutergrafikasi.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.quar.kompyutergrafikasi.MainActivity;
import uz.quar.kompyutergrafikasi.R;
import uz.quar.kompyutergrafikasi.adapter.MundarijaAdapter;
import uz.quar.kompyutergrafikasi.model.MundarijaModel;
import uz.quar.kompyutergrafikasi.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("BOSH SAHIFA", 0));
        data.add(new MundarijaModel("KIRISH", 2));
        data.add(new MundarijaModel("TA’LIMDA AXBOROT TEXNOLOGIYALARI FANNING PREDMETI, MAQSADI VA VAZIFALARI. ZAMONAVIY KOMPYUTERLAR VA ULARNING ARXITEKTURASI", 6));
        data.add(new MundarijaModel("ALGORITM VA UNING ASOSIY XOSSALARI. DASTURLASH TILLARI. PASCAL DASTURLASH TILI", 40));
        data.add(new MundarijaModel("ELEKTRON JADVAL MUHARRIRLARI. MS EXCEL DASTURI. MULTIMEDIANING ASOSIY TUSHUNCHALARI. AUDIO VA VIDEO AXBOROTLAR BILAN ISHLASH ASOSLARI. TARJIMON DASTURLAR. PROMT DASTURI", 60));
        data.add(new MundarijaModel("KOMPYUTER TARMOQLARI VA ULARNING TURLARI. INTERNET TARMOG’I VA UNING TASHKIL ETILISHI. WEB SAHIFA YARATISH TEXNOLOGIYALARI", 84));
        data.add(new MundarijaModel("TIZIM TUSHUNCHASI. AXBOROT TIZIMLARI. AXBOROTLARNI HIMOYALASHNING TEXNIK VA DASTURIY VOSITALARI. ELEKTRON TIJORAT TIZIMLARI VA ELEKTRON RAQAMLI IMZO", 120));
        data.add(new MundarijaModel("OVOZ VA GRAFIK, MATNLI AXBOROTLARNI KODLASH. KOMPYUTER VA MOBIL QURILMALAR OPERATSION TIZIMLARI", 169));
        data.add(new MundarijaModel("TURBO PASCAL DASTURLASH MUHITI. PASCAL TILIDA IFODALARINING YOZILISHI. CHIZIQLI VA SHARTLI OPERATORLAR DASTURI", 186));
        data.add(new MundarijaModel("EXCELNING TA’LIM JARAYONIDAGI IMKONIYATLARI .TAQDIMOTLAR MUHARRIRLARI VA ULARDA ISHLASH. OFFIS DASTURLARINI BIR BIRI BILAN BOG'LANISHINI HOSIL QILISH (OLE TEXNOLOGIYASI)", 197));
        data.add(new MundarijaModel("COREL DRAW DASTURINING USKUNALAR PANELI BILAN TANISHISH. ADOBE PHOTOSHOP DASTURUNING ASOSIY IMKONIYATLARI. MAXSUS EFFEKTLAR YARATISH", 210));
        data.add(new MundarijaModel("PROMT TARJIMON DASTURI BILAN ISHLASH. MA'LUMOTLARNI FORMALAR YORDAMIDA KIRITISH. MA'LUMOTLAR BAZASINI BOSHQARISH", 225));
        data.add(new MundarijaModel("HTML TILIDA WEB-SAHIFA YARATISH IMKONIYATLARI. HTML TILIDA WEB-SAHIFA YARATISH IMKONIYATLARI. DREAMWEAVER DASTURI YORDAMIDA WEB-SAHIFA YARATISH", 244));
        data.add(new MundarijaModel("AXBOROTLARNI HIMOYALASHNING TEXNIK VA DASTURIY VOSITALARI", 252));
        data.add(new MundarijaModel("NAMUNAVIY TEST SAVOLLARI", 259));
        data.add(new MundarijaModel("GLOSSARY", 275));
        data.add(new MundarijaModel("FOYDALANILGAN ADABIYOTLAR", 281));


        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}