package tn.os.projects.controller

import org.scalatest.Matchers
import org.scalatest.WordSpecLike
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import tn.os.projects.business.QueryBusiness
import javax.inject.Inject
import scala.concurrent.Await
import scala.concurrent.duration._
import tn.os.projects.business.ReportBusiness
import tn.os.projects.dao.CountryDaoImpl
import tn.os.projects.dao.AirportDaoImpl

class ReportBusinessSpec extends WordSpecLike with Matchers {

  val reportBusiness = new ReportBusiness(new CountryDaoImpl, new AirportDaoImpl)
  "Report Business Test" should {
    "get Countries with High Airports Number" in {
      val reportResponse = Await.result(reportBusiness.getCountriesWithHighAirportsNumber, 15 seconds)
      reportResponse.length shouldEqual 10
      reportResponse.head.country.name shouldEqual "United States"
    }
    "get Countries with lowest Airports Number" in {
      val reportResponse = Await.result(reportBusiness.getCountriesWithLowestAirportsNumber, 15 seconds)
      reportResponse.length shouldEqual 10
      reportResponse.head.country.name shouldEqual "Gibraltar"
    }
  }

}
