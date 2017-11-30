package tn.os.projects.dao

import scala.concurrent.Future

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import tn.os.projects.business.utils.CsvReader
import tn.os.projects.model.Airport
import tn.os.projects.model.Runway
import tn.os.projects.model.Country

class RunwayDaoImpl{
  lazy val fileName: String = "conf/csv/runways.csv"
  lazy val runways: List[Runway] = new CsvReader(fileName)
  .readAndParse((line, headers) => Runway(line, headers))

  def getRunways(airport: Airport): Future[List[Runway]] = Future {
    runways.filter(runway => runway.airportRef == airport.id)
  }  
}