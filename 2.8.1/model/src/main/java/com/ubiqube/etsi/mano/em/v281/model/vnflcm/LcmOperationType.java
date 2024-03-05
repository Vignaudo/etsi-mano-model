/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.em.v281.model.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The enumeration LcmOpType defines the permitted values to represent VNF lifecycle operation  types in VNF lifecycle management operation occurrence resources and VNF lifecycle management  operation occurrence notifications. It shall comply with the provisions defined in table 5.5.4.5-1.       Value | Description ------|------------ INSTANTIATE | Represents the \"Instantiate VNF\" LCM operation.    SCALE | Represents the \"Scale VNF\" LCM operation. SCALE_TO_LEVEL | Represents the \"Scale VNF to Level\" LCM operation. CHANGE_FLAVOUR | Represents the \"Change VNF Flavour\" LCM operation. TERMINATE | Represents the \"Terminate VNF\" LCM operation. HEAL | Represents the \"Heal VNF\" LCM operation. OPERATE | Represents the \"Operate VNF\" LCM operation. CHANGE_EXT_CONN | Represents the \"Change external VNF connectivity\" LCM operation. MODIFY_INFO | Represents the \"Modify VNF Information\" LCM operation.      
 */
public enum LcmOperationType {
  
  INSTANTIATE("INSTANTIATE"),
  
  SCALE("SCALE"),
  
  SCALE_TO_LEVEL("SCALE_TO_LEVEL"),
  
  CHANGE_FLAVOUR("CHANGE_FLAVOUR"),
  
  TERMINATE("TERMINATE"),
  
  HEAL("HEAL"),
  
  OPERATE("OPERATE"),
  
  CHANGE_EXT_CONN("CHANGE_EXT_CONN"),
  
  MODIFY_INFO("MODIFY_INFO");

  private String value;

  LcmOperationType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static LcmOperationType fromValue(String text) {
    for (LcmOperationType b : LcmOperationType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

