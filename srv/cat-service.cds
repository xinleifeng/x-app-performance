using sap.crun.performance as my from '../db/data-model';

service PerformanceDataService {
    @readonly entity SNGLRECOUT as projection on my.SNGLRECOUT;
    @readonly entity SNGLRECIN as projection on my.SNGLRECIN;
    @readonly entity AGGRECOUT as projection on my.AGGRECOUT;
    @readonly entity AGGRECIN as projection on my.AGGRECIN;
    @readonly entity Books as projection on my.Books;
}
