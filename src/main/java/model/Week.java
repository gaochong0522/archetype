package model;

/**
 * Created by 高崇 on 2017/6/28.
 */
public enum Week {
//    星期一：Monday [mʌndei]
//    星期二：Tuesday [tju:zdei]
//    星期三：Wednesday [wænsedi]
//    星期四：Thursday [θə:zdei]
//    星期五：Friday [fraidei]
//    星期六：Saturday [sætədei]
//    星期天：Sunday [[sʌndei]
        Monday("星期一",1),Tuesday("星期二",2),Wednesday("星期三",3),Thursday("星期四",4),Friday("星期五",5),Saturday("星期六",6),Sunday("星期日",7);
        private String name;
        private int index;
        private Week(String name,int index){
            this.name =name;
            this.index =index;
        }
    public static String getName(int index){
            for (Week week:Week.values()){
                if (week.getIndex() == index)
                    return  week.name;
            }
            return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
