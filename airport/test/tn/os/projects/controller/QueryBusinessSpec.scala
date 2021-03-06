package tn.os.projects.controller

import org.scalatest.Matchers
import org.scalatest.WordSpecLike
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import tn.os.projects.business.QueryBusiness
import javax.inject.Inject
import scala.concurrent.Await
import scala.concurrent.duration._
import tn.os.projects.dao.AirportDaoStub
import tn.os.projects.dao.CountryDaoStub
import tn.os.projects.dao.RunwayDaoStub
import tn.os.projects.business.QueryBusiness
import tn.os.projects.dao.CountryDaoImpl
import tn.os.projects.dao.RunwayDaoImpl
import tn.os.projects.dao.AirportDaoImpl

class QueryBusinessSpec extends WordSpecLike with Matchers {
  
   val queryBusiness = new QueryBusiness(new CountryDaoImpl, new AirportDaoImpl, new RunwayDaoImpl)
  "Query Business Test" should {
     "find  airports and runways using Country Code" in {
       val queryResponse = Await.result(queryBusiness.search("TN"), 15 seconds)
         queryResponse.length shouldEqual  15
         queryResponse.head.airport.name  shouldEqual "Medenine Airport"
     }

  }  

}
