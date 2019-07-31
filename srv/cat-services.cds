using sap.crun.performance as my from '../db/data-model';

service PerformanceDataService {
    entity SNGLRECOUT as projection on my.SNGLRECOUT;
    entity SNGLRECIN as projection on my.SNGLRECIN;
    entity AGGRECOUT as projection on my.AGGRECOUT;
    entity AGGRECIN as projection on my.AGGRECIN;
    @readonly entity STATUS_OVERVIEW as projection on my.STATUS_OVERVIEW;
}
