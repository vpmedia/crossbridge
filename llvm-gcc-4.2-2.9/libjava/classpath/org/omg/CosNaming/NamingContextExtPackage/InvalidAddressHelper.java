/* InvalidAddressHelper.java --
   Copyright (C) 2005 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */


package org.omg.CosNaming.NamingContextExtPackage;

import gnu.CORBA.OrbRestricted;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StructMember;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

/**
* The holder for exception {@link InvalidAddress}.
*
* @author Audrius Meskauskas, Lithuania (AudriusA@Bioinformatics.org)
*/
public abstract class InvalidAddressHelper
{
  /**
   * The {@link InvalidAddress} repository id.
   */
  private static String _id =
    "IDL:omg.org/CosNaming/NamingContextExt/InvalidAddress:1.0";

  /**
   * Extract the exception from the given {@link Any}.
   */
  public static InvalidAddress extract(Any a)
  {
    return read(a.create_input_stream());
  }

  /**
   * Return the exception repository id.
   */
  public static String id()
  {
    return _id;
  }

  /**
   * Insert the exception into the given {@link Any}.
   */
  public static void insert(Any a, InvalidAddress that)
  {
    a.insert_Streamable(new InvalidAddressHolder(that));
  }

  /**
   * Read the exception from the given CDR stream.
   */
  public static InvalidAddress read(InputStream istream)
  {
    InvalidAddress value = new InvalidAddress();

    // Read and discard the repository ID.
    istream.read_string();
    return value;
  }

  /**
   * Create the type code for this exception.
   */
  public static TypeCode type()
  {
    return OrbRestricted.Singleton.create_struct_tc(InvalidAddressHelper.id(),
                                       "InvalidAddress", new StructMember[0]);
  }

  public static void write(OutputStream ostream, InvalidAddress value)
  {
    // Write the repository ID.
    ostream.write_string(id());
  }
}
