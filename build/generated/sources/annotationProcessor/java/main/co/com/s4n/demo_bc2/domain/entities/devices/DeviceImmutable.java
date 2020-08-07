package co.com.s4n.demo_bc2.domain.entities.devices;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Device}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code new DeviceImmutable.Builder()}.
 * Use the static factory method to create immutable instances:
 * {@code DeviceImmutable.of()}.
 */
@Generated(from = "Device", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class DeviceImmutable implements Device {
  private final String hash;
  private final BiometryType biometryType;

  private DeviceImmutable(String hash, BiometryType biometryType) {
    this.hash = Objects.requireNonNull(hash, "hash");
    this.biometryType = Objects.requireNonNull(biometryType, "biometryType");
  }

  private DeviceImmutable(
      DeviceImmutable original,
      String hash,
      BiometryType biometryType) {
    this.hash = hash;
    this.biometryType = biometryType;
  }

  /**
   * @return The value of the {@code hash} attribute
   */
  @JsonProperty("hash")
  @Override
  public String hash() {
    return hash;
  }

  /**
   * @return The value of the {@code biometryType} attribute
   */
  @JsonProperty("biometryType")
  @Override
  public BiometryType biometryType() {
    return biometryType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#hash() hash} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for hash
   * @return A modified copy of the {@code this} object
   */
  public final DeviceImmutable withHash(String value) {
    String newValue = Objects.requireNonNull(value, "hash");
    if (this.hash.equals(newValue)) return this;
    return new DeviceImmutable(this, newValue, this.biometryType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#biometryType() biometryType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for biometryType
   * @return A modified copy of the {@code this} object
   */
  public final DeviceImmutable withBiometryType(BiometryType value) {
    if (this.biometryType == value) return this;
    BiometryType newValue = Objects.requireNonNull(value, "biometryType");
    if (this.biometryType.equals(newValue)) return this;
    return new DeviceImmutable(this, this.hash, newValue);
  }

  /**
   * This instance is equal to all instances of {@code DeviceImmutable} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof DeviceImmutable
        && equalTo((DeviceImmutable) another);
  }

  private boolean equalTo(DeviceImmutable another) {
    return hash.equals(another.hash)
        && biometryType.equals(another.biometryType);
  }

  /**
   * Computes a hash code from attributes: {@code hash}, {@code biometryType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + hash.hashCode();
    h += (h << 5) + biometryType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Device} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Device")
        .omitNullValues()
        .add("hash", hash)
        .add("biometryType", biometryType)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Device", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Device {
    String hash;
    BiometryType biometryType;
    @JsonProperty("hash")
    public void setHash(String hash) {
      this.hash = hash;
    }
    @JsonProperty("biometryType")
    public void setBiometryType(BiometryType biometryType) {
      this.biometryType = biometryType;
    }
    @Override
    public String hash() { throw new UnsupportedOperationException(); }
    @Override
    public BiometryType biometryType() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static DeviceImmutable fromJson(Json json) {
    DeviceImmutable.Builder builder = new DeviceImmutable.Builder();
    if (json.hash != null) {
      builder.setHash(json.hash);
    }
    if (json.biometryType != null) {
      builder.setBiometryType(json.biometryType);
    }
    return builder.create();
  }

  /**
   * Construct a new immutable {@code Device} instance.
   * @param hash The value for the {@code hash} attribute
   * @param biometryType The value for the {@code biometryType} attribute
   * @return An immutable Device instance
   */
  public static DeviceImmutable of(String hash, BiometryType biometryType) {
    return new DeviceImmutable(hash, biometryType);
  }

  /**
   * Creates an immutable copy of a {@link Device} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Device instance
   */
  public static DeviceImmutable copyOf(Device instance) {
    if (instance instanceof DeviceImmutable) {
      return (DeviceImmutable) instance;
    }
    return new DeviceImmutable.Builder()
        .from(instance)
        .create();
  }

  /**
   * Builds instances of type {@link DeviceImmutable DeviceImmutable}.
   * Initialize attributes and then invoke the {@link #create()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Device", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_HASH = 0x1L;
    private static final long INIT_BIT_BIOMETRY_TYPE = 0x2L;
    private long initBits = 0x3L;

    private String hash;
    private BiometryType biometryType;

    /**
     * Creates a builder for {@link DeviceImmutable DeviceImmutable} instances.
     * <pre>
     * new DeviceImmutable.Builder()
     *    .setHash(String) // required {@link Device#hash() hash}
     *    .setBiometryType(co.com.s4n.demo_bc2.domain.entities.devices.BiometryType) // required {@link Device#biometryType() biometryType}
     *    .create();
     * </pre>
     */
    public Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Device} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Device instance) {
      Objects.requireNonNull(instance, "instance");
      setHash(instance.hash());
      setBiometryType(instance.biometryType());
      return this;
    }

    /**
     * Initializes the value for the {@link Device#hash() hash} attribute.
     * @param hash The value for hash 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("hash")
    public final Builder setHash(String hash) {
      this.hash = Objects.requireNonNull(hash, "hash");
      initBits &= ~INIT_BIT_HASH;
      return this;
    }

    /**
     * Initializes the value for the {@link Device#biometryType() biometryType} attribute.
     * @param biometryType The value for biometryType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("biometryType")
    public final Builder setBiometryType(BiometryType biometryType) {
      this.biometryType = Objects.requireNonNull(biometryType, "biometryType");
      initBits &= ~INIT_BIT_BIOMETRY_TYPE;
      return this;
    }

    /**
     * Builds a new {@link DeviceImmutable DeviceImmutable}.
     * @return An immutable instance of Device
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public DeviceImmutable create() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new DeviceImmutable(null, hash, biometryType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_HASH) != 0) attributes.add("hash");
      if ((initBits & INIT_BIT_BIOMETRY_TYPE) != 0) attributes.add("biometryType");
      return "Cannot build Device, some of required attributes are not set " + attributes;
    }
  }
}
