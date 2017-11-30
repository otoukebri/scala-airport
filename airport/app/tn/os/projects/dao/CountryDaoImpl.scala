package tn.os.projects.dao

import tn.os.projects.model.Country
import tn.os.projects.business.utils.CsvReader

class CountryDaoImpl {
  
  lazy val fileName: String = "conf/csv/countries.csv"
  
  lazy val countries: List[Country] = new CsvReader(fileName)
    .readAndParse((line, headers) => Country(line, headers))
}