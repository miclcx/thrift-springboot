/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.intellif.jianyi.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2018-6-23")
public class FaceSearchCountResult implements org.apache.thrift.TBase<FaceSearchCountResult, FaceSearchCountResult._Fields>, java.io.Serializable, Cloneable, Comparable<FaceSearchCountResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FaceSearchCountResult");

  private static final org.apache.thrift.protocol.TField RETURN_RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("returnResult", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FaceSearchCountResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FaceSearchCountResultTupleSchemeFactory());
  }

  private ReturnResult returnResult; // required
  private long count; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RETURN_RESULT((short)1, "returnResult"),
    COUNT((short)2, "count");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RETURN_RESULT
          return RETURN_RESULT;
        case 2: // COUNT
          return COUNT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __COUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RETURN_RESULT, new org.apache.thrift.meta_data.FieldMetaData("returnResult", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ReturnResult.class)));
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FaceSearchCountResult.class, metaDataMap);
  }

  public FaceSearchCountResult() {
  }

  public FaceSearchCountResult(
    ReturnResult returnResult,
    long count)
  {
    this();
    this.returnResult = returnResult;
    this.count = count;
    setCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FaceSearchCountResult(FaceSearchCountResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetReturnResult()) {
      this.returnResult = new ReturnResult(other.returnResult);
    }
    this.count = other.count;
  }

  public FaceSearchCountResult deepCopy() {
    return new FaceSearchCountResult(this);
  }

  @Override
  public void clear() {
    this.returnResult = null;
    setCountIsSet(false);
    this.count = 0;
  }

  public ReturnResult getReturnResult() {
    return this.returnResult;
  }

  public void setReturnResult(ReturnResult returnResult) {
    this.returnResult = returnResult;
  }

  public void unsetReturnResult() {
    this.returnResult = null;
  }

  /** Returns true if field returnResult is set (has been assigned a value) and false otherwise */
  public boolean isSetReturnResult() {
    return this.returnResult != null;
  }

  public void setReturnResultIsSet(boolean value) {
    if (!value) {
      this.returnResult = null;
    }
  }

  public long getCount() {
    return this.count;
  }

  public void setCount(long count) {
    this.count = count;
    setCountIsSet(true);
  }

  public void unsetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RETURN_RESULT:
      if (value == null) {
        unsetReturnResult();
      } else {
        setReturnResult((ReturnResult)value);
      }
      break;

    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETURN_RESULT:
      return getReturnResult();

    case COUNT:
      return Long.valueOf(getCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RETURN_RESULT:
      return isSetReturnResult();
    case COUNT:
      return isSetCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FaceSearchCountResult)
      return this.equals((FaceSearchCountResult)that);
    return false;
  }

  public boolean equals(FaceSearchCountResult that) {
    if (that == null)
      return false;

    boolean this_present_returnResult = true && this.isSetReturnResult();
    boolean that_present_returnResult = true && that.isSetReturnResult();
    if (this_present_returnResult || that_present_returnResult) {
      if (!(this_present_returnResult && that_present_returnResult))
        return false;
      if (!this.returnResult.equals(that.returnResult))
        return false;
    }

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_returnResult = true && (isSetReturnResult());
    list.add(present_returnResult);
    if (present_returnResult)
      list.add(returnResult);

    boolean present_count = true;
    list.add(present_count);
    if (present_count)
      list.add(count);

    return list.hashCode();
  }

  @Override
  public int compareTo(FaceSearchCountResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetReturnResult()).compareTo(other.isSetReturnResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturnResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.returnResult, other.returnResult);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FaceSearchCountResult(");
    boolean first = true;

    sb.append("returnResult:");
    if (this.returnResult == null) {
      sb.append("null");
    } else {
      sb.append(this.returnResult);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("count:");
    sb.append(this.count);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (returnResult != null) {
      returnResult.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FaceSearchCountResultStandardSchemeFactory implements SchemeFactory {
    public FaceSearchCountResultStandardScheme getScheme() {
      return new FaceSearchCountResultStandardScheme();
    }
  }

  private static class FaceSearchCountResultStandardScheme extends StandardScheme<FaceSearchCountResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FaceSearchCountResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RETURN_RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.returnResult = new ReturnResult();
              struct.returnResult.read(iprot);
              struct.setReturnResultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.count = iprot.readI64();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FaceSearchCountResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.returnResult != null) {
        oprot.writeFieldBegin(RETURN_RESULT_FIELD_DESC);
        struct.returnResult.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI64(struct.count);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FaceSearchCountResultTupleSchemeFactory implements SchemeFactory {
    public FaceSearchCountResultTupleScheme getScheme() {
      return new FaceSearchCountResultTupleScheme();
    }
  }

  private static class FaceSearchCountResultTupleScheme extends TupleScheme<FaceSearchCountResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FaceSearchCountResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReturnResult()) {
        optionals.set(0);
      }
      if (struct.isSetCount()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReturnResult()) {
        struct.returnResult.write(oprot);
      }
      if (struct.isSetCount()) {
        oprot.writeI64(struct.count);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FaceSearchCountResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.returnResult = new ReturnResult();
        struct.returnResult.read(iprot);
        struct.setReturnResultIsSet(true);
      }
      if (incoming.get(1)) {
        struct.count = iprot.readI64();
        struct.setCountIsSet(true);
      }
    }
  }

}
