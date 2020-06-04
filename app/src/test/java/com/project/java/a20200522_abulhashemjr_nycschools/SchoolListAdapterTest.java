package com.project.java.a20200522_abulhashemjr_nycschools;

import android.app.Application;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.paging.PagedList;

import com.project.java.a20200522_abulhashemjr_nycschools.fakemodels.SchoolListDirectory;
import com.project.java.models.SchoolDirectory;
import com.project.java.schoollist.recycler.SchoolListAdapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 21)
public class SchoolListAdapterTest {
    private SchoolListAdapter sut;
    private List<SchoolDirectory> list = new ArrayList<>();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.sut = new SchoolListAdapter(18, "400", "ABCD", new SchoolListAdapter.SchoolListItemClickListener() {
            @Override
            public <T> void onItemClicked(SchoolListAdapter.ItemClickType type, T data) {

            }
        });

        SchoolDirectory dir1 = new SchoolDirectory();
        dir1.setBin("123");
        dir1.setSchoolName("ABC");
        dir1.setWebsite("www.abc.com");

        SchoolDirectory dir2 = new SchoolDirectory();
        dir1.setBin("456");
        dir1.setSchoolName("DEF");
        dir1.setWebsite("www.def.com");

        SchoolDirectory dir3 = new SchoolDirectory();
        dir1.setBin("789");
        dir1.setSchoolName("hij");
        dir1.setWebsite("www.hij.com");

        SchoolDirectory dir4 = new SchoolDirectory();
        dir1.setBin("101");
        dir1.setSchoolName("klm");
        dir1.setWebsite("www.klm.com");

        this.list.add(dir1);
        this.list.add(dir2);
        this.list.add(dir3);
        this.list.add(dir4);

        PagedList<SchoolDirectory> pagedList = convertListToPagedList(this.list);
        this.sut.submitList(pagedList);
    }

    @Test
    public void test_listNotNull() {
        Assert.assertNotNull(this.sut.getCurrentList());
    }
    @Test
    public void test_itemCount_shouldReturn4() {
        Assert.assertEquals(4, this.sut.getItemCount());
    }

    private <T> PagedList<T> convertListToPagedList(List<T> list) {
        PagedList<T> pagedList = (PagedList<T>) Mockito.mock(PagedList.class);
        Mockito.when(pagedList.get(ArgumentMatchers.anyInt())).then(invocation -> {
            Integer index = (Integer) invocation.getArguments()[0];
            return list.get(index);
        });
        Mockito.when(pagedList.size()).thenReturn(list.size());
        return pagedList;
    }
}
