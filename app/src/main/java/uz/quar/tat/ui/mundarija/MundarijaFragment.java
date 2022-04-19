package uz.quar.tat.ui.mundarija;

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
import uz.quar.tat.MainActivity;
import uz.quar.tat.R;
import uz.quar.tat.adapter.MundarijaAdapter;
import uz.quar.tat.model.MundarijaModel;
import uz.quar.tat.ui.home.HomeFragment;

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
        data.add(new MundarijaModel("TA’LIMDA AXBOROT TEXNOLOGIYALARI FANNING PREDMETI, MAQSADI VA VAZIFALARI. ZAMONAVIY KOMPYUTERLAR VA ULARNING ARXITEKTURASI", 7));
        data.add(new MundarijaModel("ALGORITM VA UNING ASOSIY XOSSALARI. DASTURLASH TILLARI. PASCAL DASTURLASH TILI", 51));
        data.add(new MundarijaModel("ELEKTRON JADVAL MUHARRIRLARI. MS EXCEL DASTURI. MULTIMEDIANING ASOSIY TUSHUNCHALARI. AUDIO VA VIDEO AXBOROTLAR BILAN ISHLASH ASOSLARI. TARJIMON DASTURLAR. PROMT DASTURI", 77));
        data.add(new MundarijaModel("KOMPYUTER TARMOQLARI VA ULARNING TURLARI. INTERNET TARMOG’I VA UNING TASHKIL ETILISHI. WEB SAHIFA YARATISH TEXNOLOGIYALARI", 107));
        data.add(new MundarijaModel("TIZIM TUSHUNCHASI. AXBOROT TIZIMLARI. AXBOROTLARNI HIMOYALASHNING TEXNIK VA DASTURIY VOSITALARI. ELEKTRON TIJORAT TIZIMLARI VA ELEKTRON RAQAMLI IMZO", 153));
        data.add(new MundarijaModel("OVOZ VA GRAFIK, MATNLI AXBOROTLARNI KODLASH. KOMPYUTER VA MOBIL QURILMALAR OPERATSION TIZIMLARI", 215));
        data.add(new MundarijaModel("TURBO PASCAL DASTURLASH MUHITI. PASCAL TILIDA IFODALARINING YOZILISHI. CHIZIQLI VA SHARTLI OPERATORLAR DASTURI", 237));
        data.add(new MundarijaModel("EXCELNING TA’LIM JARAYONIDAGI IMKONIYATLARI .TAQDIMOTLAR MUHARRIRLARI VA ULARDA ISHLASH. OFFIS DASTURLARINI BIR BIRI BILAN BOG'LANISHINI HOSIL QILISH (OLE TEXNOLOGIYASI)", 251));
        data.add(new MundarijaModel("COREL DRAW DASTURINING USKUNALAR PANELI BILAN TANISHISH. ADOBE PHOTOSHOP DASTURUNING ASOSIY IMKONIYATLARI. MAXSUS EFFEKTLAR YARATISH", 267));
        data.add(new MundarijaModel("PROMT TARJIMON DASTURI BILAN ISHLASH. MA'LUMOTLARNI FORMALAR YORDAMIDA KIRITISH. MA'LUMOTLAR BAZASINI BOSHQARISH", 285));
        data.add(new MundarijaModel("HTML TILIDA WEB-SAHIFA YARATISH IMKONIYATLARI. HTML TILIDA WEB-SAHIFA YARATISH IMKONIYATLARI. DREAMWEAVER DASTURI YORDAMIDA WEB-SAHIFA YARATISH", 309));
        data.add(new MundarijaModel("AXBOROTLARNI HIMOYALASHNING TEXNIK VA DASTURIY VOSITALARI", 319));
        data.add(new MundarijaModel("NAMUNAVIY TEST SAVOLLARI", 327));
        data.add(new MundarijaModel("GLOSSARY", 343));
        data.add(new MundarijaModel("FOYDALANILGAN ADABIYOTLAR", 351));


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