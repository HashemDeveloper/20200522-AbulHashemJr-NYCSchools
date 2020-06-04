package com.project.java.a20200522_abulhashemjr_nycschools;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.project.java.a20200522_abulhashemjr_nycschools.utils.RxScheduler;
import com.project.java.models.SATScores;
import com.project.java.remote.ISchoolApi;
import com.project.java.remote.repo.SchoolRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;
import utils.ViewState;

public class TestSchoolRepo extends RxScheduler {
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    @Mock
    public ISchoolApi schoolApi;
    @InjectMocks
    public SchoolRepository sut;

    private Observable<Response<List<SATScores>>> testSATResObservable = null;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        setupRxScheduler();
    }

    @Test
    public void test_FetchScores() {
        setupSATSCoreData();
        this.sut.fetchSATScore("123");
        ViewState viewState = (ViewState) this.sut.getLiveData().getValue();
        List<SATScores> scoresList = (List<SATScores>) viewState.getData();
        Assert.assertEquals(3, scoresList.size());
        Assert.assertEquals("ABC", scoresList.get(0).getSchoolName());
        Assert.assertEquals("320", scoresList.get(1).getSatWritingAvgScore());
        Assert.assertEquals("JKL", scoresList.get(2).getSchoolName());
    }

    private void setupSATSCoreData() {
        SATScores s1 = new SATScores();
        s1.setSchoolName("ABC");
        s1.setDbn("123");
        s1.setNumOfSatTestTakers("10");
        s1.setSatMathAvgScore("400");
        s1.setSatWritingAvgScore("330");
        s1.setSatCriticalReadingAvgScore("500");

        SATScores s2 = new SATScores();
        s2.setSchoolName("BCD");
        s2.setDbn("456");
        s2.setNumOfSatTestTakers("100");
        s2.setSatMathAvgScore("100");
        s2.setSatWritingAvgScore("320");
        s2.setSatCriticalReadingAvgScore("200");

        SATScores s3 = new SATScores();
        s3.setSchoolName("JKL");
        s3.setDbn("892");
        s3.setNumOfSatTestTakers("200");
        s3.setSatMathAvgScore("450");
        s3.setSatWritingAvgScore("300");
        s3.setSatCriticalReadingAvgScore("550");

        List<SATScores> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Response<List<SATScores>> res = Response.success(list);
        this.testSATResObservable = Observable.just(res);
        Mockito.when(this.schoolApi.getSATScores(anyData())).thenReturn(this.testSATResObservable);
    }
}
