package uz.quar.kompyutergrafikasi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import uz.quar.kompyutergrafikasi.MainActivity;
import uz.quar.kompyutergrafikasi.R;


public class HomeFragment extends Fragment {

//    public static int defaultPage = 0;

    private static PDFView pdfView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        pdfView = root.findViewById(R.id.pdfView);

        loadPdfFile();
        return root;
    }



    public static void loadPdfFile() {
        pdfView.fromAsset("file.pdf")
                .spacing(2)
                .defaultPage(MainActivity.defaultPage)
                .onPageScroll((page, positionOffset) -> {
                    MainActivity.defaultPage = page;
                })
                .load();



        pdfView.setScrollX(50);
    }

    public static int getPage() {
        return pdfView.getCurrentPage();
    }



}
