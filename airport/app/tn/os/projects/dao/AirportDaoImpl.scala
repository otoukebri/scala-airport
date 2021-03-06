package tn.os.projects.dao

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import javax.inject.Inject
import tn.os.projects.business.utils.CsvReader
import tn.os.projects.model.Airport
import tn.os.projects.model.Country

class AirportDaoImpl {
  lazy val fileName: String = "conf/csv/airports.csv"

  lazy val airports: List[Airport] = new CsvReader(fileName)
    .readAndParse((line, headers) => Airport(line, headers))
}