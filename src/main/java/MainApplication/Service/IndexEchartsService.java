package MainApplication.Service;

import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class IndexEchartsService {

    @Resource
    private LoginDao loginDao;

    public List<Map<String, Integer>> indexecharts(){
        List<Map<String, Integer>> echartsbydate = loginDao.echartsbydatebygehalt();
        return echartsbydate;
    }

    public List<Integer> indexcharts2(){
       List<Integer> list = loginDao.ecahrtsbydatebyumsatz();
       return list;
    }

    public List<String> chartsabteilung(){
        List<String> list = loginDao.charts2abteilung();
        return list;
    }

    public List<Double> chartsumsatz(){
        List<Double> chartsumsatz = loginDao.chartsumsatz();
        return chartsumsatz;
    }
}
