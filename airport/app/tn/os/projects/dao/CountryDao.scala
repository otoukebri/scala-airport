package tn.os.projects.dao

import com.google.inject.ImplementedBy

import tn.os.projects.model.Country

@ImplementedBy(classOf[CountryDaoImpl])
trait CountryDao {
  def countries : List[Country]
}