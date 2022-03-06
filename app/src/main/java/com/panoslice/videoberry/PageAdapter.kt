import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.panoslice.videoberry.GalleryFragment
import com.panoslice.videoberry.PexelsFragment

class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                GalleryFragment()
            }
            1 -> {
                PexelsFragment()
            }
            else -> {
                GalleryFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Gallery"
            }
            1 -> {
                return "Pexels"
            }
        }
        return super.getPageTitle(position)
    }

}