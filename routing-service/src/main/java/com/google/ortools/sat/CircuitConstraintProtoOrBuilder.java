package com.google.ortools.sat;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface CircuitConstraintProtoOrBuilder extends MessageOrBuilder {
   List getTailsList();

   int getTailsCount();

   int getTails(int var1);

   List getHeadsList();

   int getHeadsCount();

   int getHeads(int var1);

   List getLiteralsList();

   int getLiteralsCount();

   int getLiterals(int var1);
}
