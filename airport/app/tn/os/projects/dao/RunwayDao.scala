package tn.os.projects.dao

import tn.os.projects.model.Runway
import com.google.inject.ImplementedBy

@ImplementedBy(classOf[RunwayDaoImpl])
trait RunwayDao {
  def runways: List[Runway] 
}